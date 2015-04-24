package quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

//1250
//3212
//4462

//820000/216=3796                          OK
//820000*1.83% �C�~�Q��=15006  1250           OK
//�~�v1.89% (�ɴڤH��ڤ�I1.83%�F�Ȧ�ۦ�l��0.06%)  OK
public class QuartzDemo {
	public static void main(String[] args) throws Exception{		
		
		//�ݭn���檺�{��(JobDemo.class)
		JobDetail job = new JobDetail();
		job.setName("TEST_JOB");
		job.setJobClass(JobDemo.class);
		
		//�]�w�Ƶ{�ɶ�(�C�������@��)
		CronTrigger trigger = new CronTrigger();
    	trigger.setName("dummyTriggerName");

    	//(�C�������@��)
    	//trigger.setCronExpression("0/5 * * * * ?");
    	
    	//at 17:00pm every day during the year 2013
    	trigger.setCronExpression("0 00 17 * * ? 2013");	
    	//trigger.setCronExpression("0 25 16 * * ? 2013");
		
    	//�}�l����Ƶ{...
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
	}
}
