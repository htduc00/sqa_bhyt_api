package web.model;

public class Revenue {
	private Thanhpho thanhpho;
	private long revenue;
	
	public Revenue(Thanhpho thanhpho, long revenue) {
		super();
		this.thanhpho = thanhpho;
		this.revenue = revenue;
	}

	public Thanhpho getThanhpho() {
		return thanhpho;
	}

	public void setThanhpho(Thanhpho thanhpho) {
		this.thanhpho = thanhpho;
	}

	public long getRevanue() {
		return revenue;
	}

	public void setRevanue(long revenue) {
		this.revenue = revenue;
	}
	
	
	
}
