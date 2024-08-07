package kosa.di;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

// ���� ���� ����
public class LoggingAspect {
	// �ٽ� ���� ����(insertService()) => ���� ���� ���� �Բ� ȣ��(�ٽ� ���� �޼��� ȣ�� �ð��� ����)
	// Ÿ�̸� ���� -> Ÿ�̸� �۵� -> ���� �޼��� ȣ�� -> Ÿ�̸� ���� -> �α� ���
	private Log log = LogFactory.getLog(getClass());

	// ���� ���� �޼���
	// ���� ȣ��(advice: around - ���� ���� ���)
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("�α� ����");
		// Ÿ�̸� ����
		StopWatch stopWatch = new StopWatch();

		try {
			// Ÿ�̸� ����
			stopWatch.start();
			// ���� �޼��� ȣ��
			Object obj = joinPoint.proceed(); // insertService() ȣ��
			return obj;
		} catch (Exception e) {
			throw e;
		} finally {
			// Ÿ�̸� ����
			stopWatch.stop();
			// �α� ���
			log.info(joinPoint.getSignature().getName() + " �޼��� ���� ��: " 
					+ stopWatch.getTotalTimeMillis());
		}
	}
}
