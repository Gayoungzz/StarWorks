package kr.or.ddit.security;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import kr.or.ddit.vo.UsersVO;
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
 *  2025. 9. 27.     	홍현택	          최초 생성
 *
 * </pre>
 */
@ToString
public class CustomUserDetails extends User implements RealUserWrapper{
	private final UsersVO realUser;

	public CustomUserDetails(UsersVO realUser) {
		this(realUser, null);
	}
	public CustomUserDetails(UsersVO realUser, List<? extends GrantedAuthority> authorities) {
		super(
				realUser.getUserId(),
				realUser.getUserPswd(),
				!"Y".equalsIgnoreCase(java.util.Objects.toString(realUser.getRsgntnYn(), "N")),
				true, true, true,
				Stream.concat(
					AuthorityUtils.createAuthorityList(realUser.getUserRole()).stream(),
					Optional.ofNullable(authorities).map(Collection::stream).orElse(Stream.empty())
				).toList()
		);
		this.realUser = realUser;
	}

	@Override
	public UsersVO getRealUser() {
		return realUser;
	}
}
