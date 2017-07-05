package com.boot.cases.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 将一个任务进行 切分的示例
 * 使用Fork|Join的框架来实现
 * 说明：如果一个任务，通过某种计算方式，认为该任务需要拆分为更小的2个任务，知道符合最小任务的要求
 * RecursiveTask 是有返回值的实现
 * @author Administrator
 *
 */
public class TaskSegmentationDemo extends RecursiveTask<Integer>{
	Logger loger = LoggerFactory.getLogger(TaskSegmentationDemo.class);
	
	
	//指定最小的任务的指数，满足该条件任务不再进行拆分
	private static final int THRESHOLD = 999999;
	
	private int start;
	private int end;
	
	public TaskSegmentationDemo(int start , int end ){
		this.start = start;
		this.end  = end ;
	}

	@Override
	protected Integer compute() {
		int sum = 0 ;
		boolean canCompute = (end - start) < THRESHOLD;
//		loger.info("canCompute="+canCompute);
		if(canCompute){  // 满足了最小任务的规则
			for (int i = start; i <= end; i++) {
				sum += i;
			}
		}else{
			int middle = (start + end) / 2;
			TaskSegmentationDemo taskLeft = new TaskSegmentationDemo(start,middle);
			TaskSegmentationDemo taskRight = new TaskSegmentationDemo(middle+1,end);
			taskLeft.fork();
			taskRight.fork();
			int leftResult = taskLeft.join();
			int rightResult = taskRight.join();
			sum = leftResult + rightResult ;
			
		}
		return sum;
	}

	
	public static void main(String[] args) {
		
		
		Long start = System.currentTimeMillis();
		

		
		ForkJoinPool pool = new ForkJoinPool();
		TaskSegmentationDemo task = new TaskSegmentationDemo(1,100);
		Future<Integer> result = pool.submit(task);
		
		try {
			System.out.println(result.get());
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Long time = (System.currentTimeMillis() -start )   / 1000; 
		System.out.println("耗时："+time);
	}
}
