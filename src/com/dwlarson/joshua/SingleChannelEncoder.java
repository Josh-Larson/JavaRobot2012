package com.dwlarson.joshua;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.Timer;

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
	private DigitalInput input;
	private Timer timer;
	private int pulsesPerTurn;
	private double rate;
	private PWM motor;
	
	public SingleChannelEncoder(int slot, int channel, int pulsesPerTurn, PWM motor) {
		this.input = new DigitalInput(slot, channel);
		this.tickCounter = new Counter(input);
		this.tickCounter.reset();
		this.tickCounter.start();
		this.timer = new Timer();
		this.timer.reset();
		this.timer.start();
		this.pulsesPerTurn = pulsesPerTurn;
		this.rate = 0;
		this.motor = motor;
	}
	
	private void findRate() {
		rate = tickCounter.get() / pulsesPerTurn / timer.get();
		timer.reset();
		//tickCounter.reset();
	}
	
	public double getRate() {
		findRate();
		return rate;
	}
	
	public double pidGet() {
		if (motor == null) return getRate();
		return getRate() * (motor.getSpeed() > 0 ? 1.0 : -1.0);
	}
	
	public int get() {
		return tickCounter.get();
		//return input.get() ? 1 : 0;
	}
}
