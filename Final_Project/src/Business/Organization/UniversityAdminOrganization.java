/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.UniversityAdminRole;
import java.util.ArrayList;

/**
 *
 * @author PeiLingCiang
 */
public class UniversityAdminOrganization extends Organization{

    public UniversityAdminOrganization() {
        super(Organization.Type.UniversityAdminOrg.getValue());
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList();
        roles.add(new UniversityAdminRole());
        return roles;
    }
     
}
