# Multi-Threaded File Processor

A high-performance CLI tool that processes large collections of text files concurrently using Java thread pools and the Producer–Consumer pattern.

## Features

- Multi-threaded file processing
- Producer–Consumer architecture
- Word frequency analysis
- Fault-tolerant file handling
- Sorted report generation
- CLI-based execution

## Architecture

Input Folder
↓
Producer Thread
↓
Blocking Queue
↓
Consumer Worker Threads
↓
Word Frequency Aggregator
↓
Sorted Report

## Technologies

Java
Concurrency (ThreadPool, BlockingQueue)
File I/O
Collections Framework

## Run the Project

Compile:

javac src/*.java

Run:

java Main sample-data

## Example Output

java : 120
thread : 45
file : 32

## Example Use Case

Process thousands of log files quickly using concurrent threads.

## Skills Demonstrated

Multithreading
Producer–Consumer Pattern
Concurrent Data Structures
File Processing
Performance Optimization


Producer
│
▼
BlockingQueue
│
▼
Consumer Thread Pool
│
▼
Word Counter
│
▼
Report Generator