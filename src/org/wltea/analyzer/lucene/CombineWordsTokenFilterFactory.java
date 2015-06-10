package org.wltea.analyzer.lucene;

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

public class CombineWordsTokenFilterFactory extends TokenFilterFactory {

	public CombineWordsTokenFilterFactory(Map<String, String> args) {
		super(args);
		// TODO Auto-generated constructor stub
	}

	@Override
	public TokenStream create(TokenStream ts) {
		// TODO Auto-generated method stub
		return new CombineWordsTokenFilter(ts);
	}

}
