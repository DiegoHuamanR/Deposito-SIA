import java.util.ArrayList;


public class Ordenamiento<E extends Comparable<E>> {//aqui se reliza los cambios a las cuentas y el ordenamiento
	
	protected class Element{
		int mark;
		
		Register<E> reg;
		public Element(int mark, Register<E> reg){
			this.mark=mark;
			this.reg=reg;
		}
	}
	protected ArrayList<Element> table;
	protected int m;
	protected int i=0;
	protected int dh;
	
	public int getDh() {
		return dh;
	}
	public void setDh(int dh) {
		this.dh = dh;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	public Ordenamiento(int n) {
		this.m=n;  
		this.table=new ArrayList<Element>(m);
		for(int i=0; i<m;i++) {
			this.table.add(new Element(0,null));
		}
	}

	private int orden(int key) {
		
		return key% m;
	}
	private int linearProbing(int dressHash, int key, int x) { //ordenamiento de la tabla
        int posInit = dressHash;
        do{
            if(x == 1) {
                if(table.get(dressHash).mark == 0) 
                    return dressHash;
                if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.getKey() == key)
                    return -2;
                dressHash = (dressHash + 1) % m;
            }
            if(x == -1) {
                if(table.get(dressHash).mark == 1 && table.get(dressHash).reg.getKey() == key)
                    return dressHash;
                dressHash = (dressHash + 1) % m;
            }

        }while (dressHash != posInit);
        return -1;
    }

	public void insert(int key, E reg, E dire,int monto) {
		int dressHash=orden(key);
		dressHash=linearProbing(dressHash, key,1);
		if(dressHash==-1) {
			System.out.println("Key table hash is full...");
			return;	
		}
		else if(dressHash==-2) {
			System.out.println("Key is duplicated...");
			return;	
		}
		else {
			Element aux=new Element(1, new Register<E>(key,reg,dire,monto));
			table.set(dressHash, aux);
		}
	}
	public boolean search(int key) {//Buscar un dato del txt
		int dressHash=orden(key);
		E resp;
		E respd;
		int respe;
		
		dressHash=linearProbing(dressHash, key,-1);
		
		if(dressHash!=-1) {
			resp=table.get(dressHash).reg.getNombre();
			respd=table.get(dressHash).reg.getApellido();
			respe=table.get(dressHash).reg.getMonto();
			System.out.println("Usuario encontrado, el usuario es: "+resp+" "+respd);	
			return true;
		}
		else {
			return false;
		}
	}
	public void montonuevo(int key,int deposito) {//Deposito en la cantidad de la cuenta
		int dressHash=orden(key);
		E resp;
		E respd;
		int respe;
		dressHash=linearProbing(dressHash, key,-1);
		if(dressHash!=-1) {
			resp=table.get(dressHash).reg.getNombre();
			respd=table.get(dressHash).reg.getApellido();
			
			respe=table.get(dressHash).reg.getMonto();
			respe=respe+deposito;
			table.get(dressHash).reg.setMonto(respe);
			System.out.println("Se realizo con exito el deposito al usuario: "+resp+" "+respd);	
		}
		else {
			System.out.println("No se realizo con exito el deposito ");
		}
	}

	@Override
	public String toString() {
		String s="Posicion   Cuenta   Monto   Nombre/Apellido\n";
		int i=0;
		for(Element item : table) {
			s+=(i++)+" -->\t";
			if(item.mark==1)
				s+=item.reg+"\n";
			else
				s+="empty\n";
			
		}
		return s;
	}
}