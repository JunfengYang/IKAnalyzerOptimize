/**
 * IK 中文分词  版本 5.0
 * IK Analyzer release 5.0
 * 
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * 源代码由林良益(linliangyi2005@gmail.com)提供
 * 版权声明 2012，乌龙茶工作室
 * provided by Linliangyi and copyright 2012 by Oolong studio
 * Modify by JunfengYang, 2014
 */

package org.wltea.analyzer.lucene;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

/**
 * ChineseSpaceFilter
 * 2014-11
 *
 */
public class ChineseSpaceFilter extends TokenFilter {
	// Char term attribute
	private CharTermAttribute charTermAttr;
	
	/**
	 * init
	 */
	public ChineseSpaceFilter(TokenStream input) {
		super(input);
		// TODO Auto-generated constructor stub
		this.charTermAttr = addAttribute(CharTermAttribute.class);
	}

	/**
	 * eliminate the space between words
	 */
	@Override
	public boolean incrementToken() throws IOException {
		// TODO Auto-generated method stub
		if (!input.incrementToken()) {
			return false;
		}
		
		int length = charTermAttr.length();
	    char[] buffer = charTermAttr.buffer();
	    StringBuilder stringBuilder = new StringBuilder("");
	    for (int i = 0; i < length; i++) {
	      if (buffer[i] == ' ') {
	    	  if (i == 0) {
				continue;
	    	  }
	    	  if (i < length-1) {
	    		  
	    		  if(String.valueOf(buffer[i-1]).matches("[\\u4E00-\\u9FA5]+") && String.valueOf(buffer[i+1]).matches("[\\u4E00-\\u9FA5]+"))
		    	  {
		    		  continue;
		    	  }
	    	  }
	    	  if (buffer[i-1] == ' ') {
					continue;
	    	  }
	      }
	      stringBuilder.append(buffer[i]);
	    }
	    charTermAttr.setEmpty();
	    charTermAttr.copyBuffer(stringBuilder.toString().toCharArray(), 0, stringBuilder.toString().toCharArray().length);
	    return true;
	}

}
