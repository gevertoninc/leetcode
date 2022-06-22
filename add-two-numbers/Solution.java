import java.math.BigInteger;

class Solution {
  public static void main(String[] args) {
    ListNode node0 = new Solution().new ListNode(4, new Solution().new ListNode(3));
    ListNode node1 = new Solution().new ListNode(2, node0);
    ListNode node2 = new Solution().new ListNode(6, new Solution().new ListNode(4));
    ListNode node3 = new Solution().new ListNode(5, node2);

    System.out.println(addTwoNumbers(node1, node3));
  }

  private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    BigInteger summedConcatenatedDigits = concatenateDigits(l1).add(concatenateDigits(l2));
    String string = summedConcatenatedDigits.toString();
    StringBuilder stringBuilder = new StringBuilder(string);
    StringBuilder reversedStringBuilder = stringBuilder.reverse();
    String reversedString = reversedStringBuilder.toString();
    String[] reverseSummedConcatenatedDigits = reversedString.split("");

    ListNode nextNode = null;

    for (int i = reverseSummedConcatenatedDigits.length - 1; i > -1; --i) {
      int parsedNumber = Integer.parseInt(reverseSummedConcatenatedDigits[i]);

      ListNode currentNode = new Solution().new ListNode(parsedNumber, nextNode);

      nextNode = currentNode;
    }

    return nextNode;
  }

  private static BigInteger concatenateDigits(ListNode node) {
    StringBuilder concatenatedDigits = new StringBuilder();

    do {
      concatenatedDigits.append(String.valueOf(node.val));

      node = node.next;
    } while (node != null);

    return new BigInteger(concatenatedDigits.reverse().toString());
  }

  class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }

    @Override
    public String toString() {
      String string = String.valueOf(val);

      if (next != null) {
        return string + " -> " + next.toString();
      }

      return string;
    }
  }
}
