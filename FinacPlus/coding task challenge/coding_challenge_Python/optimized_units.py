def optimized_units(units,max_value):
    total_units_used = 0
    unit_counts = [0] * (max_value + 1)

    # Dynamic programming approach to find the minimum number of units for each value
    for value in range(1, max_value + 1):
        min_units = float('inf')
        for unit in units:
            if value >= unit:
                min_units = min(min_units, unit_counts[value - unit] + 1)
        unit_counts[value] = min_units
        total_units_used += min_units

    # Calculate average units used
    average_units = total_units_used / max_value

    # Print results
    print(f"Units used: {units}")
    print(f"Average units used: {average_units}")

print("Enter the values: ")
units = list(map(int,input().split()))
max_value = int(input())
# Run the function
optimized_units(units,max_value)