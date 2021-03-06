/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoempresalvp.datos;

import java.text.Collator;




public class Cliente extends Dato  implements Comparable<Cliente>{
    
    public static String[] orden = {"NUMEROCLIENTE", "CIF", "DESCRIPCION", "NOMBRE", "DOMICILIO","LOCALIDAD", "CP", "PROVINCIA", "PERSONACONTACTO", "TLFCLIENTE","TLFCONTACTO", "NOTAS", 
                                    "REFBANCO","IBAN", "BANCOCOBRO"};
    private static final String tabla = "CLIENTES";
    /**
     *   Las claves son: NUMEROCLIENTE, CIF, DESCRIPCION, NOMBRE, DOMICILIO,
     *          LOCALIDAD, CP, PROVINCIA, PERSONACONTACTO, TLFCLIENTE,
     *          TLFCONTACTO, NOTAS, ENTIDAD, SUCURSAL, DC, CUENTA, REFBANCO,
     *          IBAN, BANCOCOBRO
     * 
     * @param numeroCliente
     * @param cif
     * @param descripcion
     * @param nombre
     * @param domicilio
     * @param localidad
     * @param cp
     * @param provincia
     * @param personaContacto
     * @param tlfCliente
     * @param tlfContacto
     * @param notas
     * @param refBanco
     * @param iban
     * @param bancoCobro 
     */
   public Cliente( int numeroCliente, int cif, String descripcion,
    String nombre,String domicilio,String localidad,int cp,
    String provincia,String personaContacto,int tlfCliente,int tlfContacto,
    String notas,int refBanco,String iban,int bancoCobro) {
        this.put("NUMEROCLIENTE", numeroCliente);
        this.put("CIF",cif);
        this.put("DESCRIPCION",descripcion);
        this.put("NOMBRE",nombre);
        this.put("DOMICILIO",domicilio);
        this.put("LOCALIDAD",localidad);
        this.put("CP",cp);
        this.put("PROVINCIA",provincia);
        this.put("PERSONACONTACTO",personaContacto);
        this.put("TLFCLIENTE",tlfCliente);
        this.put("TLFCONTACTO",tlfContacto);
        this.put("NOTAS",notas);
        this.put("REFBANCO",refBanco);
        this.put("IBAN",iban);
        this.put("BANCOCOBRO",bancoCobro);
    }

    @Override
    public String devuelveNombreTablaDato() {
        return tabla;
    }

    @Override
    public String[] devuelveOrdenDeColumnas() {
        
        return orden;
    }

    @Override
    public int compareTo(Cliente o) {
        
        Collator c = Collator.getInstance();
        c.setStrength(Collator.PRIMARY);
        
        Object obj;
        Object objO;
        
        for(String clave : orden){
            
            obj = this.get(clave);
            objO = o.get(clave);
            if(obj instanceof Integer){
                
                if((int)obj != (int)objO){
            
                    return (int)obj > (int)objO ? 1 : -1;            
                }
            }else if(obj instanceof String){
                if(c.compare((String)obj, (String)objO) != 0){
            
                    return c.compare(obj, objO);            
                }
            }else if(obj instanceof Float){
                
                if((float)obj != (float)objO){
            
                    return (float)obj > (float)objO ? 1 : -1;
                }
            }         
            
        }
        
        return 0;
    }

    /**
     * La clave es NUMEROCLIENTE
     * @return 
     */
    @Override
    public Object devuelveValorClave() {
        
        return this.get("NUMEROCLIENTE");
    }

    public static String[] getOrden() {
        return orden;
    }

    public static String getTabla() {
        return tabla;
    }

    @Override
    public String devuelveClave() {
        
        return "NUMEROCLIENTE";
    }
    
}
