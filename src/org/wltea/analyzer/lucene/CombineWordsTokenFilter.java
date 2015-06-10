package org.wltea.analyzer.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class CombineWordsTokenFilter extends TokenFilter {
	private CharTermAttribute charTermAttr;
	
	public CombineWordsTokenFilter(TokenStream input) {
		super(input);
		// TODO Auto-generated constructor stub
		this.charTermAttr = addAttribute(CharTermAttribute.class);
	}

	@Override
	public boolean incrementToken() throws IOException {
		// TODO Auto-generated method stub
		if (!input.incrementToken()) {
			return false;
		}
		CharTermAttribute term = input.addAttribute(CharTermAttribute.class);
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.setLength(0);
		stringBuilder.append(term.buffer(),0,term.length());
		while (input.incrementToken()) {
			if (stringBuilder.length() > 0) {
				stringBuilder.append(' ');
			}
			stringBuilder.append(term.buffer(),0,term.length());
			term.setEmpty();
			term.setLength(0);
		}
		charTermAttr.setEmpty();
		//charTermAttr.append(stringBuilder);
		charTermAttr.copyBuffer(stringBuilder.toString().toCharArray(), 0, stringBuilder.toString().toCharArray().length);
		return true;
	}

}
