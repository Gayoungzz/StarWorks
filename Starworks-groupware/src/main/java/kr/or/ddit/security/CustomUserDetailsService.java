package kr.or.ddit.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.mybatis.mapper.PoliciesMapper;
import kr.or.ddit.mybatis.mapper.UsersMapper;
import kr.or.ddit.security.CustomUserDetailsService.FeatureAuthority;
import kr.or.ddit.vo.PoliciesDetailVO;
import kr.or.ddit.vo.UsersVO;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 *
 * @author 홍현택
 * @since 2025. 9. 27.
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 *   수정일      			수정자           수정내용
 *  -----------   	-------------    ---------------------------
 *  2025. 2025. 9. 27.     	홍현택	          최초 생성
 *
 * </pre>
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UsersMapper mapper;
	@Autowired
	private PoliciesMapper policiesMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsersVO realUser = mapper.selectUser(username);

		if(realUser==null) {
			throw new UsernameNotFoundException(String.format("%s 아이디의 회원 없음.", username));
		}

		List<FeatureAuthority> featureAuthorities = featureAuthorities(realUser);

		if(featureAuthorities.isEmpty()) {
			return new CustomUserDetails(realUser);
		}else {
			return new CustomUserDetails(realUser, featureAuthorities);
		}
	}

	private List<FeatureAuthority> featureAuthorities(UsersVO realUser) {
		return policiesMapper.selectPoliciesList().stream()
				.filter(policy->
					policy.getPoliciesDetailList()
						  .stream()
						  .anyMatch(
							  pd->hasAuthority(realUser, pd)
						  )
				).map(p->new FeatureAuthority(p.getFeatureId()))
				.toList();
	}

	private final boolean hasAuthority(UsersVO realUser, PoliciesDetailVO pd){
		String deptId = realUser.getDeptId();
		String upDeptId = realUser.getUpDeptId();
		String jbgdCd = realUser.getJbgdCd();
		int jbgdSeq = Integer.parseInt(jbgdCd.substring(4));
		boolean deptMatched = pd.getDeptId().equals(deptId) || pd.getDeptId().equals(upDeptId);
		String pdJbgdCd = pd.getJbgdCd();
		int pdJbgdSeq = Integer.parseInt(pdJbgdCd.substring(4));
		boolean jbgdMatched = pdJbgdCd.equals(jbgdCd) || jbgdSeq < pdJbgdSeq;

		return deptMatched && jbgdMatched;
	}

	@ToString
	@RequiredArgsConstructor
	public static class FeatureAuthority implements GrantedAuthority{

		private final String featureId;

		@Override
		public String getAuthority() {
			return featureId;
		}

	}

}