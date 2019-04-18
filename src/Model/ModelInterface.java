/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Timy
 */
public interface ModelInterface {
    public ResultSet list();
    
    public boolean create(List<String> request);
    
    public boolean update(List<String> request, Integer id);
    
    public boolean delete(Integer id);
}
