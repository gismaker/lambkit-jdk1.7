/**
 * Copyright (c) 2015-2017, Henry Yang 杨勇 (gismail@foxmail.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.lambkit.component.shiro.freemarker;

import freemarker.core.Environment;
import freemarker.log.Logger;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import org.apache.shiro.session.Session;

import java.io.IOException;
import java.util.Map;

/**
 * <p>Tag used to print out the String value of a user's default principal,
 * or a specific principal as specified by the tag's attributes.</p>
 * <p/>
 * <p> If no attributes are specified, the tag prints out the <tt>toString()</tt>
 * value of the user's default principal.  If the <tt>type</tt> attribute
 * is specified, the tag looks for a principal with the given type.  If the
 * <tt>property</tt> attribute is specified, the tag prints the string value of
 * the specified property of the principal.  If no principal is found or the user
 * is not authenticated, the tag displays nothing unless a <tt>defaultValue</tt>
 * is specified.</p>
 * <p/>
 * <p>Equivalent to {@link org.apache.shiro.web.tags.PrincipalTag}</p>
 *
 * @since 0.2
 */
public class LoginUsernameTag extends SecureTag {
  static final Logger log = Logger.getLogger("LoginUsernameTag");

  public static final String DEFAULT_USERNAME_PARAM = "username";

  @Override
  public void render(Environment env, Map params, TemplateDirectiveBody body) throws IOException, TemplateException {
    String result = null;
    Session session = getSubject().getSession();
    if (session != null && session.getAttribute(DEFAULT_USERNAME_PARAM) != null) {
      if (log.isDebugEnabled()) {
        log.debug("tempUser is exsit.");
      }

      String username = session.getAttribute(DEFAULT_USERNAME_PARAM).toString();
      if (username != null) {
        result = username;
      }
    } else {
      if (log.isDebugEnabled()) {
        log.debug("Attr is not exsit.");
      }
    }


    if (result != null) {
      try {
        env.getOut().write(result);
      } catch (IOException ex) {
        throw new TemplateException("Error writing [" + result + "] to Freemarker.", ex, env);
      }
    } else {
      renderBody(env, body);
    }
  }
}