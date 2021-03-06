package moiss.oracle.apps.moiss.doclib.server;



import moiss.oracle.apps.moiss.doclib.poplist.server.categoryVOImpl;
import moiss.oracle.apps.moiss.doclib.poplist.server.deptVOImpl;
import moiss.oracle.apps.moiss.doclib.ppr.server.PPRVOImpl;

import oracle.apps.fnd.framework.OARow;
import oracle.apps.fnd.framework.OAViewObject;
import oracle.apps.fnd.framework.server.OAApplicationModuleImpl;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MoissAMImpl extends OAApplicationModuleImpl {
    /**This is the default constructor (do not remove)
     */
    public MoissAMImpl() {
    }

    /**Container's getter for DocIdUVO
     */
    public DocIdUVOImpl getDocIdUVO() {
        return (DocIdUVOImpl)findViewObject("DocIdUVO");
    }

    /**Container's getter for DocLibUserVO
     */
    public DocLibUserVOImpl getDocLibUserVO() {
        return (DocLibUserVOImpl)findViewObject("DocLibUserVO");
    }
    
    public void deleteRecord(String docNumber,String vNumber)
    {
    
   // int docNo = Integer.parseInt(docNumber);
   
   System.out.println("Document Number and Verision Number Test"+docNumber+vNumber);
    OAViewObject vo = (OAViewObject)getDocLibVO();
    vo.getRowCount();
    
//    vo.reset();
//    vo.executeQuery();
   // vo.first();
    DocLibVORowImpl row = null;
    // This tells us the number of rows that have been fetched in the
    // row set, and will not pull additional rows in like some of the other "get count" methods.
    int fetchedRowCount = vo.getFetchedRowCount();
    System.out.println("Fetched Row Cound"+fetchedRowCount);
    // We use a separate iterator -- even though we could step through the
    // rows without it -- because we don't want to affect row currency.
    RowSetIterator deleteIter = vo.createRowSetIterator("deleteIter");
    System.out.println("deleteIter"+deleteIter);
    if (fetchedRowCount > 0)
    {
    deleteIter.setRangeStart(0);
    deleteIter.setRangeSize(fetchedRowCount);
    for (int i = 0; i < fetchedRowCount; i++)
    {
    row = (DocLibVORowImpl)deleteIter.getRowAtRangeIndex(i);
    // For performance reasons, we generate ViewRowImpls for all
    // View Objects. When we need to obtain an attribute value,
    // we use the named accessors instead of a generic String lookup.
    // Number primaryKey = (Number)row.getAttribute("EmployeeId");
    String primaryKey = row.getDocumentNumber();
    String primaryKey1 = row.getVersionNumber();
    if ((primaryKey.compareTo(docNumber) == 0)&&(primaryKey1.compareTo(vNumber) == 0))
    {
    // This performs the actual delete.
    System.out.println("values disp wil be del"+primaryKey+""+primaryKey1+""+row.getDocumentName());
    row.remove();

    getTransaction().commit();
    break; // only one possible selected row in this case
    }
    }
    }
    // Always close the iterator when you're done.
    deleteIter.closeRowSetIterator();
    } // end deleteRecord



        public void handlePPRAction()
        {
            Number val = Integer.valueOf(1);
            OAViewObject vo = (OAViewObject)findViewObject("PPRVO");
            if(vo != null && vo.getFetchedRowCount() == 0)
            {
                vo.setMaxFetchSize(0);
                vo.executeQuery();
                vo.insertRow(vo.createRow());
                OARow row = (OARow)vo.first();
                row.setAttribute("RowKey", val);
              //  row.setAttribute("UpdTableDispAttr", Boolean.FALSE);
             //   row.setAttribute("DispAdminAttr", Boolean.FALSE);
            }
        }

        public void createRecord(String voname)
        {
          System.out.println((new StringBuilder()).append("Name of First VO1").append(voname).toString());
            OAViewObject vo = (OAViewObject)findViewObject(voname);
            System.out.println(vo);
            if(!vo.isPreparedForExecution())
            {
                vo.executeQuery();
            }
            Row row = vo.createRow();
            vo.insertRow(row);
            row.setNewRowState((byte)-1);
            System.out.println("New Row has been created");
        }

        public void apply()
        {
            getTransaction().commit();
            System.out.println("Commitred");
        }

        public OARow obtainRow(String rowRef)
        {
            OAViewObject vo = (OAViewObject)getDocIdUVO();
            System.out.println("Getting the VO"+vo);
            OARow row = (OARow)findRowByRef(rowRef);
            System.out.println((new StringBuilder()).append("Obtaining the row reference").append(row).toString());
            if(row != null)
            {
                System.out.println(row.getAttribute("DocId"));
            }
            return row;
        }


    /**Container's getter for PPRVO
     */
    public PPRVOImpl getPPRVO() {
        return (PPRVOImpl)findViewObject("PPRVO");
    }

    /**Container's getter for deptVO
     */
    public deptVOImpl getdeptVO() {
        return (deptVOImpl)findViewObject("deptVO");
    }

    /**Container's getter for categoryVO
     */
    public categoryVOImpl getcategoryVO() {
        return (categoryVOImpl)findViewObject("categoryVO");
    }

    /**Sample main for debugging Business Components code using the tester.
     */
    public static void main(String[] args) {
        launchTester("moiss.oracle.apps.moiss.doclib.server", /* package name */
      "MoissAMLocal" /* Configuration Name */);
    }

    /**Container's getter for DocLibVO1
     */
    public DocLibVOImpl getDocLibVO1() {
        return (DocLibVOImpl)findViewObject("DocLibVO1");
    }

    /**Container's getter for DocLibVO
     */
    public DocLibVOImpl getDocLibVO() {
        return (DocLibVOImpl)findViewObject("DocLibVO");
    }
}
