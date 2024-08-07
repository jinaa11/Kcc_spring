package kosa.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// xml ����ϴ� �뵵 - �ڹ� ���Ϸ� ����� ���� ����
// ���� ���Ϸ� �����Ͽ� ���
// @Configuration
public class Factory {
	@Bean
	// �޼ҵ�� => ID��
	public Dao oracleDao() {
		// ������ �����̳ʿ��� ������
		return new OracleDao();
	}
	
	@Bean
	public Service writeService2() {
		return new WriteService();
	}
}
