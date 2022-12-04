package com.demain.common.generator;

import com.baomidou.mybatisplus.annotation.IdType;
import com.demain.generator.config.CodeGeneratorConfig;
import com.demain.generator.config.GeneratorInfoConfig;

/**
 * 代码生成
 *
 * @author demain_lee
 * @since 0.0.1
 */
public class CodeGeneratorConfigTest {

	public static void main(String[] args) {

		GeneratorInfoConfig generatorInfoConfig = new GeneratorInfoConfig.Builder().author("demain_lee").dbUrl(
				"jdbc:mysql://xxxx:3306/blog-cloud?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=GMT%2B8")
				.username("root").password("xxxx").packageName("com.demain.content")
				.outputDir("/Users/ming/IdeaProjects/blog-cloud/blog-service/blog-content/src/main/java")
				.mapperDir(
						"/Users/ming/IdeaProjects/blog-cloud/blog-service/blog-content/src/main/java/com/demain/content/mapper")
				.tablePrefix("blog_").includeTable("blog_content").idType(IdType.ASSIGN_ID)
				// .templateEngine(new VelocityTemplateEngine())
				.enableSwagger().enableLombok().build();

		CodeGeneratorConfig.runCodeGenerator(generatorInfoConfig);
	}

}
