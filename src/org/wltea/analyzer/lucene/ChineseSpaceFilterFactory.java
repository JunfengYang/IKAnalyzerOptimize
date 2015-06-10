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

import java.util.Map;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.TokenFilterFactory;

/**
 * ChineseSpaceFilterFactory
 * 2014-11
 */
public class ChineseSpaceFilterFactory extends TokenFilterFactory {

	/**
	 * init
	 */
	public ChineseSpaceFilterFactory(Map<String, String> args) {
		super(args);
		// TODO Auto-generated constructor stub
	}

	/**
	 * create TokenStream
	 */
	@Override
	public TokenStream create(TokenStream ts) {
		// TODO Auto-generated method stub
		return new ChineseSpaceFilter(ts);
	}

}
