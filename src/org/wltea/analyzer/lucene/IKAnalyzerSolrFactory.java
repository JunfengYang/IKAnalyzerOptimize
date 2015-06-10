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

import java.io.Reader;
import java.util.Map;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource.AttributeFactory;

/**
 * IKAnalyzerSolrFactory
 * 2014-9
 *
 */
public class IKAnalyzerSolrFactory extends TokenizerFactory{
	
	//Smart mode
	private boolean useSmart;
	
	/**
	 * is smart mode
	 */
	public boolean useSmart() {
		return useSmart;
	}
	
	/**
	 * set smart mode
	 */
	public void setUseSmart(boolean useSmart) {
		this.useSmart = useSmart;
	}
	
	/**
	 * IKAnalyzerSolrFactory
	 */
	 public IKAnalyzerSolrFactory(Map<String,String> args) {
	     super(args);
	     assureMatchVersion();
	     this.setUseSmart(args.get("useSmart").toString().equals("true"));
	   }


	/**
	* create Tokenizer
	*/
    @Override
    public Tokenizer create(AttributeFactory factory, Reader input) {
        Tokenizer _IKTokenizer = new IKTokenizer(input , this.useSmart);
        return _IKTokenizer;
    }

}