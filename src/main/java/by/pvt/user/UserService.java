package by.pvt.user;

import by.pvt.pojo.AppRole;
import by.pvt.pojo.AppUser;
import by.pvt.pojo.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    public boolean saveNewUser(AppUser user, RoleName roleName) {
        if (user == null || user.getName().isEmpty() || user.getUsername().isEmpty() ||
                user.getEmail().isEmpty() || user.getPassword().isEmpty()) {
            return false;
        }
        Integer userCountByLogin = appUserRepository.findUserCountByLogin(user.getUsername());
        if (userCountByLogin != null && userCountByLogin >= 1) {
            return false;
        }
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        AppRole appRole = appRoleRepository.findRoleByName(roleName);
        if (appRole == null) {
            appRole = new AppRole();
            appRole.setRoleName(roleName);
        }
        user.setRoles(Set.of(appRole));
        appUserRepository.save(user);
        return true;
    }

    @Transactional
    public List<String> getAllRoles() {
        return appRoleRepository.getRoleNames();
    }

}