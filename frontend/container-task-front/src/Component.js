import React, { useEffect, useState } from 'react';
import axios from 'axios';
import ResultTable from './table/ResultTable';
import "./Component.css"

const Component = () => {

    const [result, setResult] = useState([]);

    useEffect(() => {
        axios.get(`http://localhost:8080/dmt/lab2/result`)
            .then((res) => {
                setResult(res.data);
            })
    }, [result]);

    return (
        <div className='component'>
            <h2>Lab 2 Results</h2>       
            <ResultTable result={result}></ResultTable>
        </div>
    );
}

export default Component;