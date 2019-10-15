/*
 * $Id$
 */

package ru.ifmo.cs.components;

/**
 *
 * @author Dmitry Afanasiev <KOT@MATPOCKuH.Ru>
 */
public class Register extends DataPart {
	public Register(long width) {
		super(width);
	}

	@Override
	public synchronized void setValue(long value) {
		this.value = value & mask;
	}

	public synchronized void setValue(long value, long mask, long startbit) {
		this.value = ((this.value & ~(mask << startbit)) | ((value & mask) << startbit)) & this.mask;
	}

	public synchronized void invertBit(long startbit) {
		long bit = 1L << startbit;

		value = (value & ~bit) | (~(value & bit) & bit);
	}
}
