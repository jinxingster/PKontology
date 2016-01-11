# PKontology
Share a literature graph, instead of a reading list!


Paper-Keyword Ontology Modelling
Jin Xing
This project aims to build a framework to build the ontology representing the relationship among papers and their keywords. The paper-keyword ontology can help the knowledge discovery in Geothink, which delineates the “hot” keywords in different research fields, as well as the most important papers related to these keywords.  As shown in Figure 1, papers (rectangles) are linked with the corresponding keywords (circles) in their content, where the correlation numbers indicating the intensity of the correlation. 
 
 ![alt tag](https://github.com/jinxingster/PKontology/blob/master/pkmodel.gif)
 
 
                   Figure 1. An example of Paper-Keyword Ontology

This project is inspired by the “population, not sample” and “correlation, not causality” strategies from Miller and Goodchild (2014). We believe the relationship number will converge to its true value (i.e., the value agreed by most research scientists in certain fields), given enough professional input. There are two types of professional input: the manual input and the artificial intelligence input. The former one is provided by the paper reviewers, while the latter on is completed using keyword extraction techniques (Matsuo and Ishizuka, 2004). 


Please note the correlation number only representing the correlation between the paper and given keywords, which is not used to measure the quality of the paper itself. The correlation number can be calculated as the weight over all the inputs containing this keyword. The number of inputs can help us to tell if a keyword can be considered as a “hot topic”, while the correlation number indicates the most important paper. We can use this framework to extract the hot topics for a conference, the most important paper for certain research fields, and the change of hot topics in journals. Moreover, a literature ontology can give students more help than a reading list. 


Reference


Matsuo, Y., & Ishizuka, M. (2004). Keyword extraction from a single document using word co-occurrence statistical information. International Journal on Artificial Intelligence Tools, 13(01), 157-169.
Miller, H. J., & Goodchild, M. F. (2014). Data-driven geography. GeoJournal, 1-13.
