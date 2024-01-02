package linyuju.formbindingtest.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRegModel  //先定義Model
{
    String uname;
    String email;
    String mobile;
    String address;
}
