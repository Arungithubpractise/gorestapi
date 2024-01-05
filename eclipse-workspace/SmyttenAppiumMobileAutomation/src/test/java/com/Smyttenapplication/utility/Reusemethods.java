package com.Smyttenapplication.utility;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.Smyttenapplication.testcase.SmyttenBaseclass;

public class Reusemethods extends SmyttenBaseclass{
	
	public void taponelement(WebElement ele)
	{
	Point location = ele.getLocation();
	Dimension size = ele.getSize();
	
	Point centerofele = getcenterofelement(location,size);	
		
					
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,  "finger1");

			Sequence sequence = new Sequence(finger1, 1)
			.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofele))
			.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofMillis(200)))
			.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

			driver.perform(Collections.singletonList (sequence)) ;
	}

	public void Doubletaponelement(WebElement ele)
	{
	Point location = ele.getLocation();
	Dimension size = ele.getSize();
	
	Point centerofele = getcenterofelement(location,size);	
		
					
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,  "finger1");

			Sequence sequence = new Sequence(finger1, 1)
			.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofele))
			.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofMillis(100)))
			.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofMillis(100)))
			.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofMillis(100)))
			.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			driver.perform(Collections.singletonList (sequence)) ;
	}

	public void Longpress(WebElement ele)
	{
	Point location = ele.getLocation();
	Dimension size = ele.getSize();
	
	Point centerofele = getcenterofelement(location,size);	
		
					
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,  "finger1");

			Sequence sequence = new Sequence(finger1, 1)
			.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofele))
			.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofSeconds(2)))
			.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
					
			driver.perform(Collections.singletonList (sequence)) ;
	}
	
	public void Zoom(WebElement ele)
	{
	Point location = ele.getLocation();
	Dimension size = ele.getSize();
	
	Point centerofele = getcenterofelement(location,size);	
		
					
	PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH,  "finger1");

			Sequence sequence1 = new Sequence(finger1, 1)
					
			.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofele))
			.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofMillis(200)))
			.addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerofele.getX()+100, centerofele.getY()-100))
			.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
					
			
			PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH,  "finger1");

			Sequence sequence2 = new Sequence(finger2, 1)
					
			.addAction(finger2.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerofele))
			.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
			.addAction(new Pause(finger1, Duration.ofSeconds(2)))
			.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			driver.perform(Arrays.asList(sequence1,sequence2)) ;
			
	}
		
	
	
	
	
	
	
			public Point getcenterofelement(Point location, Dimension size )
			{
				return new Point(location.getX()+ size.getWidth()/2, location.getY()+size.getHeight()/2);
				
			}

}
