/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prj321.securityConfig;

import com.prj321.dao.RoleFeatureDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Admin
 */
public class AuthorConfig {
    
    private RoleFeatureDAO roleFeatureDao = new RoleFeatureDAO();
    
    private HashMap<String, List<String>> AUTHOR_MAP = 
            new HashMap<String, List<String>>();
    private List<String> ADMIN = new ArrayList<String>();
    private List<String> MOD = new ArrayList<String>();
    private List<String> GUEST = new ArrayList<String>();

    public AuthorConfig() {
        for (int i = 0; i < roleFeatureDao.getServletPath("1").size(); i++) {
            ADMIN.add(roleFeatureDao.getServletPath("1").get(i));
        }
        for (int i = 0; i < roleFeatureDao.getServletPath("2").size(); i++) {
            ADMIN.add(roleFeatureDao.getServletPath("1").get(i));
        }
        AUTHOR_MAP.put("1", ADMIN);
        AUTHOR_MAP.put("2", MOD);
        AUTHOR_MAP.put("3", GUEST);
        
    }

    public List<String> getADMIN() {
        return ADMIN;
    }

    public List<String> getMOD() {
        return MOD;
    }
    
    
    
    
    
    public boolean isAuthorized(String roleId, String servletPath){
        for (String key: AUTHOR_MAP.keySet()){
            if (key.equals(roleId)){
                for (int i = 0; i < AUTHOR_MAP.get(key).size(); i++){
                    if (AUTHOR_MAP.get(key).get(i).equals(servletPath)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
