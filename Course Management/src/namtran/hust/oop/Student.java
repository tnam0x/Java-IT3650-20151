package namtran.hust.oop;

public class Student extends Person {
	private String mssv;
	private String nienKhoa;
	private int diemMonHoc;

	public String getMssv() {
		return mssv;
	}

	public void setMssv(String mssv) {
		this.mssv = mssv;
	}

	public String getNienKhoa() {
		return nienKhoa;
	}

	public void setNienKhoa(String nienKhoa) {
		this.nienKhoa = nienKhoa;
	}

	public int getDiemMonHoc() {
		return diemMonHoc;
	}

	public void setDiemMonHoc(int diemMonHoc) {
		this.diemMonHoc = diemMonHoc;
	}
}
