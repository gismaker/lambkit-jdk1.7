##create bean,this is a class
#parse("/template/java_copyright.include")
package $!{basepackage}.rpc.api;

import com.lambkit.common.service.BaseServiceMock;

import $!{basepackage}.rpc.model.${classname};

#parse("/template/java_author.include")
public class ${classname}ServiceMock extends BaseServiceMock<${classname}> {
}