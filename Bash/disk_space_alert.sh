#!/bin/bash

# Set the threshold for disk space (in percentage)
threshold=40
# Check disk space usage
disk_usage=$(df -h / | awk 'NR==2 {print $6}' | tr -d '%' | cut -d'G' -f1)
echo $disk_usage

# Compare with the threshold
if [ "$disk_usage" -ge "$threshold" ]; then
    # Send alert/notification (replace with your notification mechanism)
    echo "Warning: Disk space usage is above $threshold%. Consider freeing up space." >> ./Space_Log
else
    echo "Disk space usage is within acceptable limits." >> ./Space_Log
fi

