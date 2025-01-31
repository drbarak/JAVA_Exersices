package תרגילים_נוספים;

import static Library.Print.p;

public class LinkList
{
    private IntNodeMat _head;
    private int[] _list;

    public LinkList()
    {
        _head = null;
    }
    public LinkList(int[] list)
    {
        if (list == null) return;    // verifies the input is not null
        if (_head != null) return;   // verifies the chain does not already exists
        
        _list = new int[list.length];
        _list[0] = list[0];
        
        createList(list, true);
    }
    private void createList(int[] list, boolean copy)
    {
        IntNodeMat last = new IntNodeMat(list[0]);
        _head = last;
        for (int i = 1; i < list.length; i++)
        {
            if (copy) _list[i] = list[i];
            IntNodeMat cell = new IntNodeMat(list[i]);
            last.setNext(cell);
            last = cell;
        }
    }

    public String toString()
    {
        return toString(_head);
    }
    private String toString(IntNodeMat head)
    {
        if (_head == null) return "";
        IntNodeMat cell = head;
        String s = "{";
        while (cell != null)
        {
           s += cell.getValue() + ",";
           cell = cell.getNext();
        }
        return s.substring(0, s.length()-1) + "}";
    }
    
    public int countList()
    {
        if (_head == null) return 0;
        Object[] result = countListPrivate();
        int midNum = (int)result[0];
        int endNum = (int)result[1];
        IntNodeMat midNode = (IntNodeMat)result[2];
        p(midNum, endNum);
        p(midNode.getValue());
        return endNum;
    }
    private Object[] countListPrivate()
    {
        IntNodeMat mid = _head;
        IntNodeMat midPrev = _head;
        IntNodeMat end = _head;
        IntNodeMat last = _head;
        int midNum = 1, endNum = 1;
        while (end != null && end.getNext() != null)
        {
            last = end.getNext();
            end = end.getNext().getNext();   // move forward 2 nodes at a time
            if (end != null) last = end;
            midPrev = mid;
            mid = mid.getNext();
            midNum++;
            endNum += 2;
        }
        if (end == null)
        {
            endNum--;
            midNum--;
        }
        if (endNum % 2 == 0) mid = midPrev;
        return new Object[]{midNum, endNum, mid};
    }

    public void reveseList()
    {
        IntNodeMat newHead = reveseList(_head);
        if (newHead == null) return;
        p(toString(newHead));
        // restore original list
        createList(_list, false);
        p(toString());
        return;
    }
    private IntNodeMat reveseList(IntNodeMat head)
    {
        if (head == null) return null;
        IntNodeMat cur = head;
        IntNodeMat next = cur.getNext();
        IntNodeMat prev = cur;
        while (next != null)
        {
            cur = next;
            next = next.getNext();
            cur.setNext(prev);
            prev = cur;
        }
        head.setNext(null);
        head = cur;
        return head;
    }
    boolean p = false;
    public boolean isPalindrom()
    {
        if (_head == null) return true;
        p = false;
        // find middle of the list
        Object[] result = countListPrivate();
        int midNum = (int)result[0];
        int endNum = (int)result[1];
        IntNodeMat midNode = (IntNodeMat)result[2];
        /*
        p(midNum, endNum);
        p(midNode.getValue());
        p(toString());
        */
        // reverse the right half of the list
        IntNodeMat newHead = midNode.getNext();
        midNode.setNext(null);
        newHead = reveseList(newHead);
        if (p) p(toString(newHead));
        if (p) p(toString());
        
        IntNodeMat left = _head;
        IntNodeMat right = newHead;
        boolean _isPalindrom = true;
        while (left != null && right != null && _isPalindrom)
        {
            if (left.getValue() != right.getValue())
                _isPalindrom = false;
            else
            {
                left = left.getNext();
                right = right.getNext();
            }
        }
        return _isPalindrom;
    }
}// end of class LinkList
