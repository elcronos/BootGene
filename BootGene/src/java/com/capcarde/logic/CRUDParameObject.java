package com.capcarde.logic;


public class CRUDParameObject
{

    public CRUDParameObject(String nombVar, String tipo, boolean nulo, boolean pkey)
    {
        nombVariable = nombVar;
        tipoVariable = tipo;
        isNull = nulo;
        isPkey = pkey;
    }
    public CRUDParameObject(String nombVar, String Fkey){
        nombVariable=nombVar;
        tipoVariable= "Number(10)";
        isNull=false;
        isPkey=false;
        fkey= Fkey;
    }

    public String getNombVariable()
    {
        return nombVariable;
    }

    public void setNombVariable(String nombVariable)
    {
        this.nombVariable = nombVariable;
    }

    public String getTipoVariable()
    {
        return tipoVariable;
    }

    public void setTipoVariable(String tipoVariable)
    {
        this.tipoVariable = tipoVariable;
    }

    public boolean isIsNull()
    {
        return isNull;
    }

    public void setIsNull(boolean isNull)
    {
        this.isNull = isNull;
    }

    public boolean isIsPkey()
    {
        return isPkey;
    }

    public void setIsPkey(boolean isPkey)
    {
        this.isPkey = isPkey;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int size)
    {
        this.size = size;
    }

    public String getFkey() {
        return fkey;
    }

    public void setFkey(String fkey) {
        this.fkey = fkey;
    }
    
    

    private String nombVariable;
    private String tipoVariable;
    private boolean isNull;
    private boolean isPkey;
    private int size;
    private String fkey;
}
