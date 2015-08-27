package com.uberdist.infra;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class CicloDeVida implements PhaseListener {

	private static final long serialVersionUID = -2967187901991926301L;

	@Override
	public void afterPhase(PhaseEvent event) {
		System.out.println("After Phase from event: " + event.getPhaseId());
	}
	
	@Override
	public void beforePhase(PhaseEvent event) {
		System.out.println("Before Phase from event: " + event.getPhaseId());
	}
	
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
	
}
