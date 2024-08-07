package kosa.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class WriteService implements Service {
	// data type�� �������� ������ �����̳ʿ��� Dao ��ü�� ã�Ƽ� ����
	@Autowired
	@Qualifier("mySQLDao") // �ʿ��� ��ü �̸��� ��Ȯ�ϰ� ���
	private Dao dao;
	
	public WriteService() {}
	
	public WriteService(Dao dao) {
		super();
		this.dao = dao;
	}

	public void insertService() {
		System.out.println("WriteService insertService() ȣ��");
		dao.insertBoard();
	}
	
	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
