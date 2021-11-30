package com.optum.fs.rest.service.util.problems;

import java.util.HashMap;
import java.util.Map;


public class DynamicVariableReplacingSolution {
    public static void main(String[] args) {
        String styleSheet = "<div style=\\\"border:none;border-bottom:solid windowt ext 1.5pt;padding:0in 0in 1.0pt 0in;\\\"><p style=\\\"border:none;padding:0in;\\\"><span style=\\\"color:gray;\\\">&nbsp;</span></p></div><p style=\\\"text-align:center;\\\"><strong><span style=\\\"font-size:21px;line-height:115%;font-family:&quot;Arial&quot;,sans-serif;color:#6D74A2;\\\">New credentialing information is ready for you on the&nbsp;</span></strong><a href=\\\"https://test-provider-og-mms.optum.com/tpa-ap-web/?navDeepDive=OC%20publicProviderHomeDefaultContentMenu\\\"><strong><span style=\\\"font-size:21px;line-height:115%;font-family:&quot;Arial&quot;,sans-serif;\\\">OMMS Provider Enrollment Portal</span></strong></a></p><p><span style=\\\"font-size:13px;line-height:115%;\\\">Dear Provider,{{templateBodyParam1}}</span></p><p><span style=\\\"font-size:13px;line-height:115%;\\\">A new communication regarding your credentialing status with the Montana Healthcare Programs network is ready for you on the OMMS Provider Enrollment Portal. Please log in to review it now.&nbsp;</span></p><p><u><span style=\\\"font-size:13px;line-height:115%;\\\">https://test-provider-og-mms.optum.com/tpa-ap-web/?navDeepDive=OC publicProviderHomeDefaultContentMenu</span></u></p><p><span style=\\\"font-size:13px;line-height:115%;\\\">Click <strong>Correspondence History</strong> from the main menu to view details of the communication. It may include time-sensitive  about your enrollment application and other important {{templateBodyParam2}}details.&nbsp;</span></p><p><span style=\\\"font-size:13px;line-height:115%;\\\">View, track, and manage your account activity online:</span></p><ul style=\\\"list-style-type: disc;margin-left:undefined;\\\"><li><span style=\\\"line-height:115%;font-size:13px;\\\">Submit applications for enrollment and re-validation</span></li><li><span style=\\\"line-height:115%;font-size:13px;\\\">Upload copies of licenses and certifications</span></li><li><span style=\\\"line-height:115%;font-size:13px;\\\">View provider management communications</span></li><li><span style=\\\"line-height:115%;font-size:13px;\\\">Submit claims&nbsp;</span></li></ul><div style=\\\"border:none;border-bottom:solid windowtext 1.5pt;padding:0in 0in 1.0pt 0in;\\\"><p style=\\\"border:none;padding:0in;\\\">&nbsp;</p></div><p><span style=\\\"font-size:11px;line-height:115%;\\\">If you'd rather receive communications from us on paper through the mail:</span></p><ul style=\\\"list-style-type: disc;margin-left:undefined;\\\"><li><span style=\\\"line-height:115%;font-size:11px;\\\">Log in at <u>https://test-provider-og-mms.optum.com/tpa-ap-web/?navDeepDive=OC publicProviderHomeDefaultContentMenu</u></span></li><li><span style=\\\"line-height:115%;font-size:11px;\\\">Click on <strong>Account Settings</strong></span></li><li><span style=\\\"line-height:115%;font-size:11px;\\\">Update your <strong>Communication Preferences{{templateBodyParam3}}</strong></span></li></ul>";

        DynamicVariableReplacingSolution dynamicVariableReplacingSolution = new DynamicVariableReplacingSolution();
        dynamicVariableReplacingSolution.replaceDynamicVariablWithStringarray(styleSheet);

    }

    public void replaceDynamicVariablWithStringarray(String paragraph) {
        Map<String, String> encodedKeyMap = new HashMap<>();
        encodedKeyMap.put("{{templateBodyParam1}}", "Shiva");
        encodedKeyMap.put("{{templateBodyParam2}}", "Bathula");
        encodedKeyMap.put("{{templateBodyParam3}}", "Hyderabad");
        encodedKeyMap.put("{{testUserAddress}}", "KareemNagar");
        encodedKeyMap.put("{{testUserCell}}", "90897890");
        encodedKeyMap.put("{{testUserX}}", "x");
        encodedKeyMap.put("{{testUserY}}", "y");
        encodedKeyMap.put("{{testUserZ}}", "Z");
        encodedKeyMap.put("{{testUserBook}}", "Geeta");
        encodedKeyMap.put("{{testUserVehicle}}", "Merc");
//While Itrerating Metadata we can insert with {{ Key }} for every key present in metadata in a map
        System.out.println(paragraph);
        System.out.println("----------------------------");
        String[] words = paragraph.split(" ");
        System.out.println("Count of words in the above Paragraph is " + words.length);

        for (int i = 0; i < words.length; i++) {// O(N) N = words.length;
            String key = words[i];
            String extractMapKey = "";
            if (key.length() >0) {
                int startOpenCurlyBrace = key.indexOf("{");
                int startClosedCurlyBrace = key.indexOf("}");
                if (key.charAt(startOpenCurlyBrace + 1) == '{' && key.charAt(startClosedCurlyBrace + 1) == '}') {
                    extractMapKey = key.substring(startOpenCurlyBrace, startClosedCurlyBrace + 2);//Extracting {{ key }}
                    String value = encodedKeyMap.get(extractMapKey);// Value to be replaced
                    if (value != null && value.length() > 0) {
                        System.out.println(i + " i Key =" + key + " replaced Value = " + key.replace(extractMapKey, value));//O(N) lookup in map is constant time i.e O(1) being Length pf the Map.
                        words[i] = key.replace(extractMapKey, value);
                    }
                }

            }
        }
        String templateBody = String.join(" ", words);
        System.out.println(templateBody);
        String string  = "{{}}";
        System.out.println(" {{ "+string.indexOf("{{"));
        System.out.println(" }} "+string.indexOf("}}"));

    }
}
