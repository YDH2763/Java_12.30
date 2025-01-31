package day20;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
	
	private String name;
	private String Id;
	private String password;
	private String authority;	//사용자, 관리자
	
	public User(String id, String password) {
		this.Id = id;
		this.password = password;
		this.authority="사용자";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(Id, other.Id);
	}


	
	
	
	
	
	
	
}
