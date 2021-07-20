
public class Register<E> implements Comparable<Register<E>> {//Clase donde se encuentran los datos de la cuenta
	protected int key;
	protected E nombre;
	protected E apellido;
	protected int monto;
	public Register(int key, E nombre, E apellido,int monto) {
		this.key=key;
		this.nombre=nombre;
		this.apellido=apellido;
		this.monto=monto;
	}
	public int compareTo(Register<E> r) {
		return this.key-r.key;
	}
	public boolean equals(Object o) {
		if(o instanceof Register) {
			Register<E> r =(Register<E>)o;
			return r.key==this.key;
		}
		return false;
	}
	
	public int getKey() {
		return this.key;
	}
	
	public E getNombre() {
		return nombre;
	}
	public void setNombre(E nombre) {
		this.nombre = nombre;
	}
	public E getApellido() {
		return apellido;
	}
	public void setApellido(E apellido) {
		this.apellido = apellido;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public String toString() {
		return this.key+" : "+"S/. "+this.monto+" : "+this.nombre+" : "+this.apellido.toString();
	}
	

}