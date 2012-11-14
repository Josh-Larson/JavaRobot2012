package com.dwlarson.joshua;

import java.util.Date;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PWM;

/**
 * A single channel encoder that does not require the B wire
 * in order for the encoder to work. You can have it detect
 * direction by specifying a PWM motor controller in the
 * constructor, otherwise it works with a PID and basic
 * functions.
 * @author Josh Larson
 */
public class SingleChannelEncoder implements PIDSource {
	
	private Counter tickCounter;
	private long startTime;
	private int pulsesPerTurn;
	private double rate;
	private PWM motor;
	
	public SingleChannelEncoder(int channel, int pulsesPerTurn, PWM motor) {
		this.tickCounter = new Counter(channel);
		this.tickCounter.start();
		this.startTime = new Date().getTime();
		this.pulsesPerTurn = pulsesPerTurn;
		this.rate = 0;
		this.motor = motor;
	}
	
	public void finalize() {
		tickCounter.stop();
	}
	
	private void findRate() {
		rate = tickCounter.get() / pulsesPerTurn / (new Date().getTime() - startTime);
		startTime = new Date().getTime();
		tickCounter.reset();
	}
	
	public double getRate() {
		findRate();
		return rate;
	}
	
	public double pidGet() {
		if (motor == null) return getRate();
		return getRate() * (motor.getSpeed() > 0 ? 1.0 : -1.0);
	}
}
