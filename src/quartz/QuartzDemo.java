package quartz;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

//1250
//3212
//4462

//820000/216=3796                          OK
//820000*1.83% 每年利息=15006  1250           OK
//年率1.89% (借款人實際支付1.83%；銀行自行吸收0.06%)  OK
public class QuartzDemo {
	public static void main(String[] args) throws Exception{		
		
		//需要執行的程式(JobDemo.class)
		JobDetail job = new JobDetail();
		job.setName("TEST_JOB");
		job.setJobClass(JobDemo.class);
		
		//設定排程時間(每五秒執行一次)
		CronTrigger trigger = new CronTrigger();
    	trigger.setName("dummyTriggerName");

    	//(每五秒執行一次)
    	//trigger.setCronExpression("0/5 * * * * ?");
    	
    	//at 17:00pm every day during the year 2013
    	trigger.setCronExpression("0 00 17 * * ? 2013");	
    	//trigger.setCronExpression("0 25 16 * * ? 2013");
		
    	//開始執行排程...
    	Scheduler scheduler = new StdSchedulerFactory().getScheduler();
    	scheduler.start();
    	scheduler.scheduleJob(job, trigger);
	}
}
