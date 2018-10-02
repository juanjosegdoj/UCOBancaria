package co.edu.uco.ucobancaria.dto;
/**
 * objeto de transferencia de datos que representa a una cuenta
 * @author Usuario
 *
 */

public final class CuentaDTO {
	private int codigo;
	private String numero;
	private TipoCuentaDTO tipoCuenta;
	private double saldo;
	private ClienteDTO cliente;
	
	public CuentaDTO() {
		super();
	}
	
	public CuentaDTO(int codigo, String numero, TipoCuentaDTO tipoCuenta, double saldo, ClienteDTO cliente) {
		super();
		setCodigo(codigo);
		setNumero(numero);
		setTipoCuenta(tipoCuenta);
		setSaldo(saldo);
		setCliente(cliente);
	}

	public final int getCodigo() {
		return codigo;
	}

	public final void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public final String getNumero() {
		return numero;
	}

	public final void setNumero(String numero) {
		this.numero = numero;
	}

	public final TipoCuentaDTO getTipoCuenta() {
		return tipoCuenta;
	}

	public final void setTipoCuenta(TipoCuentaDTO tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public final double getSaldo() {
		return saldo;
	}

	public final void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public final ClienteDTO getCliente() {
		return cliente;
	}

	public final void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	
}
