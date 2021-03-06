##create bean,this is a class
#parse("/template/java_copyright.include")
package $!{basepackage}.rpc.model;

import java.util.HashMap;
import java.util.Map;

#foreach ($table in $tables)
import $!{basepackage}.rpc.model.${table.modelName};
#end##
#foreach ($table in $tables)
import $!{basepackage}.rpc.query.${table.modelName}Query;
#end##
#foreach ($table in $tables)
import $!{basepackage}.tag.${table.modelName}Directive;
#end##

import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.lambkit.LambkitModule;

#parse("/template/java_author.include")
public class _MappingKit {

	public static void mapping(ActiveRecordPlugin arp) {
#foreach ($table in $tables)##	
#if(!${table.primaryKey})##
		arp.addMapping("$table.name", ${table.modelName}.class);
#else##
		arp.addMapping("$table.name", "${table.primaryKey}", ${table.modelName}.class);
#end##
#end##
	}
	
	public static void addTag(LambkitModule lk) {
#foreach ($table in $tables)
		lk.addTag("$table.attrName", new ${table.modelName}Directive());
#end##
	}
	
	
}

