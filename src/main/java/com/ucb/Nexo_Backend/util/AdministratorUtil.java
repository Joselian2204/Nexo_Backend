package com.ucb.Nexo_Backend.util;

import com.ucb.Nexo_Backend.dto.AdministratorInformation;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class AdministratorUtil {
    public Integer getIdAdministrator(){
        Authentication a= SecurityContextHolder.getContext().getAuthentication();
        AdministratorInformation administratorInformation=(AdministratorInformation) a.getCredentials();
        return administratorInformation.getIdAdministrator();
    }
}
