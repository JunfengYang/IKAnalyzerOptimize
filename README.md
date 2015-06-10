# IKAnalyzerOptimize
Base on IK Analyzer release 5.0. Optimize the original IKAnalyzer to support lucene 4.0 -  4.6.
Upper version none test, please give me feed back.

I'm mainly used in Solr 4.4 .

New features:

1. A IKAnalyzerSolrFactory to support solr version higher than 4.0 and extends the TokenizerFactory to support filter factory.
2. Support both simplified Chinese and traditional Chinese.
3. A ChineseSpaceFilterFactory to remove space after "ShingleFilterFactory"
	For example, "计算机算法导论" when doing the shingle for auto-complete,
	It will generate terms "计算机"， “计算机 算法”， “计算机 算法 导论”， “算法”， “算法 导论”，“导论”
	So, it we input the prefix of the whole input term like "计算机算", we want it return "计算机算法"， “计算机算法导论” 
	which not contain space between phrases.
4. English word segmentation for possessive case.
	"apple's" will be "apple's" and "apple".
	"its'" will be "its"

Example in solr schema.xml:

```xml
<fieldType name="text_ik" class="solr.TextField" positionIncrementGap="100" >
  <analyzer type="index" >
    <tokenizer class="org.wltea.analyzer.lucene.IKAnalyzerSolrFactory" useSmart="false" />
  </analyzer>
  <analyzer type="query" >
    <tokenizer class="org.wltea.analyzer.lucene.IKAnalyzerSolrFactory" useSmart="true" />
  </analyzer>
</fieldType>
```
