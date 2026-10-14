class Solution {


    public static final String HEADER_DIVIDER = "-----";

    public static final String STRING_DIVIDER = "--";

    public String encode(List<String> strs) {
        final StringBuilder payload = new StringBuilder();
        final StringBuilder header = new StringBuilder();
        boolean first = true;
        for(String str: strs){
            payload.append(str);
            if(first)  header.append(str.length());
            else header.append(STRING_DIVIDER).append(str.length());
            first=false;
        }
        return header.toString() + HEADER_DIVIDER + payload.toString();
    }

    public List<String> decode(String str) {

        int headerIndex = str.indexOf(HEADER_DIVIDER);
        String header = str.substring(0,headerIndex);
        if(header.isEmpty()) return new ArrayList<>();
        int payloadIndex = headerIndex+HEADER_DIVIDER.length();
        String payload = str.substring(payloadIndex, str.length());
        String[] sizes = header.split(STRING_DIVIDER);
        int processedIndex = 0;
        List<String> list = new ArrayList<>();
        for(String size: sizes){
            String decodedString = payload.substring(processedIndex, processedIndex+Integer.valueOf(size));
            processedIndex += decodedString.length();
            list.add(decodedString);
        }
        return list;
    }
}
