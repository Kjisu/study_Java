package ch15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Vector;

public class SequenceInputStreamEx {

	
	public static void main(String[] args) {
		
		byte[] arr1 = {0,1,2};
		byte[] arr2 = {3,4,5};
		byte[] arr3 = {6,7,8};
		
		Vector v = new Vector();
		v.add(new ByteArrayInputStream(arr1));
		v.add(new ByteArrayInputStream(arr2));
		v.add(new ByteArrayInputStream(arr3));
		
		SequenceInputStream input = new SequenceInputStream(v.elements());
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data = 0;
		try {
			while((data=input.read())!= -1) {
				output.write(data); 
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] outSrc = null;
		outSrc = output.toByteArray();
		
		System.out.println("Output Source : "+Arrays.toString(outSrc));
	}
}
