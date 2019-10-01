package B형준비;

class UserSolution {
	
	static final int hash_size = 1000;
	static final int hash_leng = 200;
	static final int hash_val = 257;
	
	// HashKey Method
	static int getHashKey(String name) {
		int key = 0;
		
		for (int i = 0; i < name.length(); i++) {
			key = (key*hash_val) + name.charAt(i);
		}
		
		if(key < 0) key = -key;
		
		return key % hash_size;
	}
	
	static int[][][] hash_table = new int[5][hash_size][hash_leng];
	
	static String[] hash_name = new String[50001];
	static String[] hash_num = new String[50001];
	static String[] hash_birth = new String[50001];
	static String[] hash_email = new String[50001];
	static String[] hash_memo = new String[50001];
	
	static int index = 1; // 레코드 인덱스
	static int[][] cnt = new int[5][hash_size];
	static boolean[] visited = new boolean[50001];
	
	void InitDB()
	{
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < hash_size; j++) {
				cnt[i][j] = 0;
			}
		}
		index = 1; // 인덱스 초기화
	}
	
	boolean isEquals(String origin, String compare) {
		
		if(origin.length() != compare.length()) return false;
		
		for (int i = 0; i < origin.length(); i++) {
			if(origin.charAt(i) != compare.charAt(i)) {
				return false;
			}
		}
		
		return true;
	}
	
	void changeVal(int number, int key, int index) {
		hash_table[number][key][cnt[number][key]++] = index;
	}

	void Add(String name, String number, String birthday, String email, String memo)
	{
		int key = getHashKey(name);
		hash_table[0][key][cnt[0][key]++] = index;
		
		key = getHashKey(number);
		hash_table[1][key][cnt[1][key]++] = index;
		
		key = getHashKey(birthday);
		hash_table[2][key][cnt[2][key]++] = index;
		
		key = getHashKey(email);
		hash_table[3][key][cnt[3][key]++] = index;
		
		key = getHashKey(memo);
		hash_table[4][key][cnt[4][key]++] = index;
		
		hash_name[index] = name;
		hash_num[index] = number;
		hash_birth[index] = birthday;
		hash_email[index] = email;
		hash_memo[index] = memo;
		
		visited[index] = false; // 방문 초기화
		index++;
	}

	int Delete(int field, String str)
	{
		int count = 0;
		int key = 0;
		
		switch (field) {
		case 0: // name
			key = getHashKey(str);
			for (int i = 0; i < cnt[0][key]; i++) {
				int index = hash_table[0][key][i];
				if(index==0) continue;
				if(isEquals(hash_name[index], str) && !visited[index]) {
					visited[index] = true;
					count++;
				}
			}
			break;
		case 1: // number
			key = getHashKey(str);
			for (int i = 0; i < cnt[1][key]; i++) {
				int index = hash_table[1][key][i];
				if(index==0) continue;
				if(isEquals(hash_num[index], str) && !visited[index]) {
					visited[index] = true;
					count++;
				}
			}
			break;
		case 2: // birthday
			key = getHashKey(str);
			for (int i = 0; i < cnt[2][key]; i++) {
				int index = hash_table[2][key][i];
				if(index==0) continue;
				if(isEquals(hash_birth[index], str) && !visited[index]) {
					visited[index] = true;
					count++;
				}
			}
			break;
		case 3: // email
			key = getHashKey(str);
			for (int i = 0; i < cnt[3][key]; i++) {
				int index = hash_table[3][key][i];
				if(index==0) continue;
				if(isEquals(hash_email[index], str) && !visited[index]) {
					visited[index] = true;
					count++;
				}
			}
			break;
		case 4: // memo
			key = getHashKey(str);
			for (int i = 0; i < cnt[4][key]; i++) {
				int index = hash_table[4][key][i];
				if(index==0) continue;
				if(isEquals(hash_memo[index], str) && !visited[index]) {
					visited[index] = true;
					count++;
				}
			}
			break;

		default:
			break;
		}
		return count;
	}

	int Change(int field, String str, int changefield, String changestr)
	{
		int count = 0;
		int key = 0;
		String origin = "";
		int originKey = 0;
		
		switch (field) {
		case 0: // name
			key = getHashKey(str);
			for (int i = 0; i < cnt[0][key]; i++) {
				int index = hash_table[0][key][i];
				if(index == 0) continue;
				if(isEquals(hash_name[index], str) && !visited[index]) {
					switch (changefield) {
					case 0:
						origin = hash_name[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[0][originKey]; j++) {
							if(hash_table[0][originKey][j] == index) {
								hash_table[0][originKey][j] = 0;
								break;
							}
						}
						hash_name[index] = changestr;
						break;
					case 1:
						origin = hash_num[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[1][originKey]; j++) {
							if(hash_table[1][originKey][j] == index) {
								hash_table[1][originKey][j] = 0;
								break;
							}
						}
						hash_num[index] = changestr;
						break;
					case 2:
						origin = hash_birth[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[2][originKey]; j++) {
							if(hash_table[2][originKey][j] == index) {
								hash_table[2][originKey][j] = 0;
								break;
							}
						}
						hash_birth[index] = changestr;
						break;
					case 3:
						origin = hash_email[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[3][originKey]; j++) {
							if(hash_table[3][originKey][j] == index) {
								hash_table[3][originKey][j] = 0;
								break;
							}
						}
						hash_email[index] = changestr;
						break;
					case 4:
						origin = hash_memo[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[4][originKey]; j++) {
							if(hash_table[4][originKey][j] == index) {
								hash_table[4][originKey][j] = 0;
								break;
							}
						}
						hash_memo[index] = changestr;
						break;

					default:
						break;
					}
					count++;
					changeVal(changefield, getHashKey(changestr), index);
				}
			}
			break;
		case 1: // number
			key = getHashKey(str);
			for (int i = 0; i < cnt[1][key]; i++) {
				int index = hash_table[1][key][i];
				if(index == 0) continue;
				if(isEquals(hash_num[index], str) && !visited[index]) {
					switch (changefield) {
					case 0:
						origin = hash_name[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[0][originKey]; j++) {
							if(hash_table[0][originKey][j] == index) {
								hash_table[0][originKey][j] = 0;
								break;
							}
						}
						hash_name[index] = changestr;
						break;
					case 1:
						origin = hash_num[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[1][originKey]; j++) {
							if(hash_table[1][originKey][j] == index) {
								hash_table[1][originKey][j] = 0;
								break;
							}
						}
						hash_num[index] = changestr;
						break;
					case 2:
						origin = hash_birth[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[2][originKey]; j++) {
							if(hash_table[2][originKey][j] == index) {
								hash_table[2][originKey][j] = 0;
								break;
							}
						}
						hash_birth[index] = changestr;
						break;
					case 3:
						origin = hash_email[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[3][originKey]; j++) {
							if(hash_table[3][originKey][j] == index) {
								hash_table[3][originKey][j] = 0;
								break;
							}
						}
						hash_email[index] = changestr;
						break;
					case 4:
						origin = hash_memo[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[4][originKey]; j++) {
							if(hash_table[4][originKey][j] == index) {
								hash_table[4][originKey][j] = 0;
								break;
							}
						}
						hash_memo[index] = changestr;
						break;

					default:
						break;
					}
					count++;
					changeVal(changefield, getHashKey(changestr), index);
				}
			}
			break;
		case 2: // birthday
			key = getHashKey(str);
			for (int i = 0; i < cnt[2][key]; i++) {
				int index = hash_table[2][key][i];
				if(index == 0) continue;
				if(isEquals(hash_birth[index], str) && !visited[index]) {
					switch (changefield) {
					case 0:
						origin = hash_name[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[0][originKey]; j++) {
							if(hash_table[0][originKey][j] == index) {
								hash_table[0][originKey][j] = 0;
								break;
							}
						}
						hash_name[index] = changestr;
						break;
					case 1:
						origin = hash_num[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[1][originKey]; j++) {
							if(hash_table[1][originKey][j] == index) {
								hash_table[1][originKey][j] = 0;
								break;
							}
						}
						hash_num[index] = changestr;
						break;
					case 2:
						origin = hash_birth[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[2][originKey]; j++) {
							if(hash_table[2][originKey][j] == index) {
								hash_table[2][originKey][j] = 0;
								break;
							}
						}
						hash_birth[index] = changestr;
						break;
					case 3:
						origin = hash_email[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[3][originKey]; j++) {
							if(hash_table[3][originKey][j] == index) {
								hash_table[3][originKey][j] = 0;
								break;
							}
						}
						hash_email[index] = changestr;
						break;
					case 4:
						origin = hash_memo[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[4][originKey]; j++) {
							if(hash_table[4][originKey][j] == index) {
								hash_table[4][originKey][j] = 0;
								break;
							}
						}
						hash_memo[index] = changestr;
						break;

					default:
						break;
					}
					count++;
					changeVal(changefield, getHashKey(changestr), index);
				}
			}
			break;
		case 3: // email
			key = getHashKey(str);
			for (int i = 0; i < cnt[3][key]; i++) {
				int index = hash_table[3][key][i];
				if(index == 0) continue;
				if(isEquals(hash_email[index], str) && !visited[index]) {
					switch (changefield) {
					case 0:
						origin = hash_name[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[0][originKey]; j++) {
							if(hash_table[0][originKey][j] == index) {
								hash_table[0][originKey][j] = 0;
								break;
							}
						}
						hash_name[index] = changestr;
						break;
					case 1:
						origin = hash_num[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[1][originKey]; j++) {
							if(hash_table[1][originKey][j] == index) {
								hash_table[1][originKey][j] = 0;
								break;
							}
						}
						hash_num[index] = changestr;
						break;
					case 2:
						origin = hash_birth[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[2][originKey]; j++) {
							if(hash_table[2][originKey][j] == index) {
								hash_table[2][originKey][j] = 0;
								break;
							}
						}
						hash_birth[index] = changestr;
						break;
					case 3:
						origin = hash_email[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[3][originKey]; j++) {
							if(hash_table[3][originKey][j] == index) {
								hash_table[3][originKey][j] = 0;
								break;
							}
						}
						hash_email[index] = changestr;
						break;
					case 4:
						origin = hash_memo[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[4][originKey]; j++) {
							if(hash_table[4][originKey][j] == index) {
								hash_table[4][originKey][j] = 0;
								break;
							}
						}
						hash_memo[index] = changestr;
						break;

					default:
						break;
					}
					count++;
					changeVal(changefield, getHashKey(changestr), index);
				}
			}
			break;
		case 4: // memo
			key = getHashKey(str);
			for (int i = 0; i < cnt[4][key]; i++) {
				int index = hash_table[4][key][i];
				if(index == 0) continue;
				if(isEquals(hash_memo[index], str) && !visited[index]) {
					switch (changefield) {
					case 0:
						origin = hash_name[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[0][originKey]; j++) {
							if(hash_table[0][originKey][j] == index) {
								hash_table[0][originKey][j] = 0;
								break;
							}
						}
						hash_name[index] = changestr;
						break;
					case 1:
						origin = hash_num[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[1][originKey]; j++) {
							if(hash_table[1][originKey][j] == index) {
								hash_table[1][originKey][j] = 0;
								break;
							}
						}
						hash_num[index] = changestr;
						break;
					case 2:
						origin = hash_birth[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[2][originKey]; j++) {
							if(hash_table[2][originKey][j] == index) {
								hash_table[2][originKey][j] = 0;
								break;
							}
						}
						hash_birth[index] = changestr;
						break;
					case 3:
						origin = hash_email[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[3][originKey]; j++) {
							if(hash_table[3][originKey][j] == index) {
								hash_table[3][originKey][j] = 0;
								break;
							}
						}
						hash_email[index] = changestr;
						break;
					case 4:
						origin = hash_memo[index];
						originKey = getHashKey(origin);
						for (int j = 0; j < cnt[4][originKey]; j++) {
							if(hash_table[4][originKey][j] == index) {
								hash_table[4][originKey][j] = 0;
								break;
							}
						}
						hash_memo[index] = changestr;
						break;

					default:
						break;
					}
					count++;
					changeVal(changefield, getHashKey(changestr), index);
				}
			}
			break;

		default:
			break;
		}
		
		return count;
	}

	Solution.Result Search(int field, String str, int returnfield)
	{
		Solution.Result result = new Solution.Result();
		result.count = 0;
		result.str = "";
		
		int key = 0;
		
		switch (field) {
		case 0: // name
			key = getHashKey(str);
			for (int i = 0; i < cnt[0][key]; i++) {
				int index = hash_table[0][key][i];
				if(index == 0) continue;
				if(isEquals(hash_name[index], str) && !visited[index]) {
					result.count++;
					if(result.count == 1) {
						switch (returnfield) {
						case 0:
							result.str = hash_name[index];
							break;
						case 1:
							result.str = hash_num[index];
							break;

						case 2:
							result.str = hash_birth[index];
							break;

						case 3:
							result.str = hash_email[index];
							break;

						case 4:
							result.str = hash_memo[index];
							break;

						default:
							break;
						}
					}
					else
						result.str = "";
				}
			}
			break;
		case 1: // number
			key = getHashKey(str);
			for (int i = 0; i < cnt[1][key]; i++) {
				int index = hash_table[1][key][i];
				if(index == 0) continue;
				if(isEquals(hash_num[index], str) && !visited[index]) {
					result.count++;
					if(result.count == 1) {
						switch (returnfield) {
						case 0:
							result.str = hash_name[index];
							break;
						case 1:
							result.str = hash_num[index];
							break;

						case 2:
							result.str = hash_birth[index];
							break;

						case 3:
							result.str = hash_email[index];
							break;

						case 4:
							result.str = hash_memo[index];
							break;

						default:
							break;
						}
					}
					else
						result.str = "";
				}
			}
			break;
		case 2: // birthday
			key = getHashKey(str);
			for (int i = 0; i < cnt[2][key]; i++) {
				int index = hash_table[2][key][i];
				if(index == 0) continue;
				if(isEquals(hash_birth[index], str) && !visited[index]) {
					result.count++;
					if(result.count == 1) {
						switch (returnfield) {
						case 0:
							result.str = hash_name[index];
							break;
						case 1:
							result.str = hash_num[index];
							break;

						case 2:
							result.str = hash_birth[index];
							break;

						case 3:
							result.str = hash_email[index];
							break;

						case 4:
							result.str = hash_memo[index];
							break;

						default:
							break;
						}
					}
					else
						result.str = "";
				}
			}
			break;
		case 3: // email
			key = getHashKey(str);
			for (int i = 0; i < cnt[3][key]; i++) {
				int index = hash_table[3][key][i];
				if(index == 0) continue;
				if(isEquals(hash_email[index], str) && !visited[index]) {
					result.count++;
					if(result.count == 1) {
						switch (returnfield) {
						case 0:
							result.str = hash_name[index];
							break;
						case 1:
							result.str = hash_num[index];
							break;

						case 2:
							result.str = hash_birth[index];
							break;

						case 3:
							result.str = hash_email[index];
							break;

						case 4:
							result.str = hash_memo[index];
							break;

						default:
							break;
						}
					}
					else
						result.str = "";
				}
			}
			break;
		case 4: // memo
			key = getHashKey(str);
			for (int i = 0; i < cnt[4][key]; i++) {
				int index = hash_table[4][key][i];
				if(index == 0) continue;
				if(isEquals(hash_memo[index], str) && !visited[index]) {
					result.count++;
					if(result.count == 1) {
						switch (returnfield) {
						case 0:
							result.str = hash_name[index];
							break;
						case 1:
							result.str = hash_num[index];
							break;

						case 2:
							result.str = hash_birth[index];
							break;

						case 3:
							result.str = hash_email[index];
							break;

						case 4:
							result.str = hash_memo[index];
							break;

						default:
							break;
						}
					}
					else
						result.str = "";
				}
			}
			break;

		default:
			break;
		}
		
		return result;
	}
}

