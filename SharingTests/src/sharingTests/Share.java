package sharingTests;

import static org.junit.Assert.*;

import org.junit.Test;

import share.ShareSeleniumTest;

public class Share {

	ShareSeleniumTest sel = new ShareSeleniumTest();
	String Title;
	String[] CreatedValue = new String[4];
	String[] ReadValue = new String[4];
	
	@Test
	public void CreatorViewAccessUserEditAccess() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to the user and "View" permission to the creator
		sel.ShareSettingsUser(false, true);
		
		sel.closeEditArea(false, true);

		//Validate that the creator doesn't have the "Edit" permission
		assertFalse(sel.getEditAccess());
		
		
		assertTrue(sel.ViewItem());
		assertFalse(sel.EditItemAvailable());
	
		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
				
		
		//Validate that the user has the "Edit" permission
		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
	} 
	
	////////////////////////////////////////////////////////////////////

	@Test
	public void CreatorViewAccessGroupEditAccess() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to the group and "View" to creator
		sel.ShareSettingsGroup("sel_group", false, true);
				
		sel.closeEditArea(false, true);
		assertFalse(sel.getEditAccess());
		
		
		//Validate that the creator doesn't have "Edit" permission
		assertTrue(sel.ViewItem());
		assertFalse(sel.EditItemAvailable());
	
		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
				
		
		//Validate that the user in the group has the "Edit" permission
		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
	} 
///////////////////////////////////////////////////////////////////
	
	@Test
	public void CreatorUserEditAccess() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to both users
		sel.ShareSettingsUser(true, true);
		
		sel.closeEditArea(true, true);

		//Validate that the creator has the "Edit" permission		
		assertTrue(sel.getEditAccess());
				
		
		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
		
		
		//Validate that the user has the "Edit" permission
		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable()); 
	
	} 
	
	/////////////////////////////////////////////////////////////////////////
	
	@Test
	public void CreatorGroupEditAccess() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to both users
		sel.ShareSettingsGroup("sel_group", true, true);
				
		sel.closeEditArea(true, true);

		//Validate that the creator has the "Edit" permission
		assertTrue(sel.getEditAccess());
		

		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
		
		
		//Validate that the user in the group has the "Edit" permission
		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
		
	} 
	
	////////////////////////////////////////////////////////////
	
	@Test
	public void CreatorEditAccessUserViewAccess() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to creator
		sel.ShareSettingsUser(true, false);
		
		sel.closeEditArea(true, false);

		//Validate that the creator has "Edit" permission
		assertTrue(sel.getEditAccess());
		

		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
		
		//Validate that the user doesn't have "Edit" permission
		assertTrue(sel.ViewItem());
		assertFalse(sel.EditItemAvailable());
	
	} 
	
	////////////////////////////////////////////////////////////
	
	@Test
	public void CreatorEditAccessGroupViewAccess() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to creator
		sel.ShareSettingsGroup("sel_group", true, false);
		
				
		sel.closeEditArea(true, false);
		

		//Validate that the creator has the "Edit" permission
		assertTrue(sel.getEditAccess());
		

		assertTrue(sel.ViewItem());
		assertTrue(sel.EditItemAvailable());
	
		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
		
		//Validate that the user in the group doesn't have "Edit" permission
		assertTrue(sel.ViewItem());
		assertFalse(sel.EditItemAvailable());
	
	} 
	
	/////////////////////////////////////////////////
	
	@Test
	public void AbsenceOfItemAfterIsNotShared() throws Exception {
		
		String UserName = "testuser2";
		String PassWord = "nterop_4dmin";
		
		//Navigate to the Login Page
		sel.setUp();
		
		//Login
		Title = sel.Login(UserName, PassWord);
		assertEquals(Title, "eParade - My Items");
		
		//Create Item and Verify that it appears in the table
		Title = sel.CreateItem();
		assertEquals(Title, "eParade - My Items");
		sel.SortandReadFirstRowMyItems();
		CreatedValue = sel.getCreateValue();
		ReadValue = sel.getReadValue();
		for (int i = 0; i < 3; i++ )
		{
			assertEquals(CreatedValue[i], ReadValue[i]);
		}
		
		//Assign the 'Edit' permission to creator
		sel.ShareSettingsUser(true, false);
		
		sel.closeEditArea(true, false);

		//Login as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
		
		//Validate that the user doesn't have "Edit" permission
		assertTrue(sel.ViewItem());
		
		//Login again as testUser2
		UserName = "testuser2";
		sel.LogOutandRelogin(UserName, PassWord);
		
		assertEquals(Title, "eParade - My Items");
		
		//Remove User1 from the list of the users that the document is shared with them
		sel.SortandReadFirstRowMyItems();
		
		sel.NotSharingWithAnyone();
		sel.closeEditArea(true, false);
		
		//Login again as testUser1
		UserName = "testuser1";
		sel.LogOutandRelogin(UserName, PassWord);
		
		assertFalse(sel.ViewItem());
		
	}
	///////////////////////////////////////////////////////////////////////
	
	

}
