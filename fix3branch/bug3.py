# Bug 1: Mutable default argument retains state across function calls
def add_item(item, item_list=[]):
  item_list.append(item)
  return item_list


def calculate_average(numbers):
  total = 0
  # Bug 2: Off-by-one range error or division by zero if list is empty
  for i in range(len(numbers) + 1):
    total += numbers[i]  # Will raise IndexError on the last iteration

  return total / len(numbers)


if __name__ == "__main__":
  print("List 1:", add_item(1))
  print("List 2:", add_item(2))  # Unexpectedly contains [1, 2]

  nums = [10, 20, 30, 40, 50]
  print("Average:", calculate_average(nums))
