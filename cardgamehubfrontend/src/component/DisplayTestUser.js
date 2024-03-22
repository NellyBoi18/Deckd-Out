import * as React from 'react';
import { DataGrid } from '@mui/x-data-grid';
import { useEffect, useState } from 'react';

const columns = [
  { field: 'id', headerName: 'ID', width: 70 },
  { field: 'name', headerName: 'NAME', width: 130 },
  { field: 'level', headerName: 'LEVEL', width: 130 },
];

export default function DisplayTestUser() {
    const [testUsersArray, setTestUsers] = useState([]);

    /**Here, we are fetching student from the api */
    useEffect(()=>{
        fetch("http://localhost:8080/testUser")
        .then(res=>res.json())
        .then(testUserObj=>setTestUsers(testUserObj))
        .catch(e=>console.log(e))
    },[testUsersArray]);


  return (
    <div style={{ height: 300, width: '40%', margin:'auto', marginBottom:'55px', marginTop:'30px' }}>
        <h2> Test User Data From Database</h2>
      <DataGrid
        rows={testUsersArray}
        columns={columns}
        pageSize={5}
        rowsPerPageOptions={[5]}
        checkboxSelection
      />
    </div>
  );
}
