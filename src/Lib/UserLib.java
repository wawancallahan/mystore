/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lib;

/**
 *
 * @author Timy
 */
public class UserLib {
    protected Integer id = null;
    protected String name = null;
    protected String username = null;
    protected String password = null;
    protected String type = null;
    
    public UserLib(int id, String name, String username, String password, String type) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.type = type;
    }
    
    /**
     *
     * @return Integer
     */
    public Integer getId() {
        return this.id;
    }
    
    /**
     *
     * @return String
     */
    public String getName() {
        return this.name;
    }
    
     /**
     *
     * @return String
     */
    public String getUsername() {
        return this.username;
    }
    
     /**
     *
     * @return String
     */
    public String getPassword() {
        return this.password;
    }
    
    /**
     *
     * @return String
     */
    public String getType() {
        return this.type;
    }
}
