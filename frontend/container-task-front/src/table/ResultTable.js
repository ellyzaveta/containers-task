import React from 'react';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import "./ResultTable.css"

const ResultTable = ({ result }) => {
    return (
      <div className="horizontal-table">
        <Paper style={{ boxShadow: 'none', border: '1px solid rgba(125, 125, 125, 0.8)' }}>
          <TableContainer>
            <Table aria-label="Alternative Table" style={{ borderCollapse: 'collapse', border: '1px solid rgba(125, 125, 125, 0.2)' }}>
              <TableHead>
                <TableRow className='highlighted-row'>
                  <TableCell className='cell'>{"Row"}</TableCell>
                  <TableCell className='cell'>{"SortType"}</TableCell>
                  <TableCell className='cell'>{"Algo"}</TableCell>
                  <TableCell className='cell'>{"Num of containers"}</TableCell>
                  <TableCell className='cell'>{"Complexity"}</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {result.map((item, index) => (
                    <TableRow>
                        <TableCell className='cell'>{item.row + 1}</TableCell>
                        <TableCell className='cell'>{item.sortType}</TableCell>
                        <TableCell className='cell'>{item.alg}</TableCell>
                        <TableCell className='cell'>{item.containerNum}</TableCell>
                        <TableCell className='cell'>{item.complexity}</TableCell>
                    </TableRow>
                ))}
              </TableBody>
            </Table>
          </TableContainer>
        </Paper>
      </div>
    );
};
  
export default ResultTable;

  
  
  
  
  